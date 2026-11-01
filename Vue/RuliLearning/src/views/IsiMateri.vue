<script setup>
import { ref, onMounted, watch } from 'vue'
import { useRoute } from 'vue-router'
import { supabase } from '../supabase'

const route = useRoute()

const kategoriMateriId = ref(route.params.id || null)

const daftarIsiMateri = ref([])
const newIsiMateri = ref({
    judul: '',
    gambar: '',
    deskripsi: ''
})
const loading = ref(true)

onMounted(() => {
    fetchIsiMateri()
})


const fetchIsiMateri = async () => {
    loading.value = true
    let query = supabase.from('isiMateri').select('*, kategoriMateri(judul)')

    if (kategoriMateriId.value) {
        query = query.eq('kategoriMateri_id', kategoriMateriId.value)
    }

    query = query.order('created_at', { ascending: true })

    const { data, error } = await query
    if (error) {
        console.error('Error fetching isi materi:', error)
    } else {
        daftarIsiMateri.value = data
    }
    loading.value = false
}

const addIsiMateri = async () => {
    if (!newIsiMateri.value.judul || !newIsiMateri.value.deskripsi) {
        alert('Judul dan Deskripsi tidak boleh kosong!')
        return
    }

    const { data, error } = await supabase
        .from('isiMateri')
        .insert([{
            judul: newIsiMateri.value.judul,
            gambar: newIsiMateri.value.gambar,
            deskripsi: newIsiMateri.value.deskripsi,
            kategoriMateri_id: kategoriMateriId.value // kalau null → masuk umum
        }])
        .select()

    if (error) {
        console.error('Error adding isi materi:', error)
    } else {
        daftarIsiMateri.value.push(data[0])
        newIsiMateri.value = { judul: '', gambar: '', deskripsi: '' }
    }
}

const deleteIsiMateri = async (id) => {
    if (!confirm('Yakin ingin menghapus konten ini?')) return

    const { error } = await supabase.from('isiMateri').delete().eq('id', id)
    if (error) {
        console.error('Error deleting isi materi:', error)
    } else {
        daftarIsiMateri.value = daftarIsiMateri.value.filter(i => i.id !== id)
    }
}
</script>

<template>
    <div class="p-8 bg-white rounded-lg shadow-md">
        <h2 class="text-2xl font-bold mb-6">
            {{ kategoriMateriId ? 'Konten Materi per Kategori' : 'Semua Konten Materi' }}
        </h2>

        <div class="bg-gray-50 p-4 rounded-lg mb-8 border">
            <h3 class="text-lg font-semibold mb-3">Tambah Konten Baru</h3>
            <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
                <input v-model="newIsiMateri.judul" type="text" placeholder="Judul Konten/Bab"
                    class="p-2 border rounded" />
                <input v-model="newIsiMateri.gambar" type="text" placeholder="URL Gambar" class="p-2 border rounded" />
            </div>
            <textarea v-model="newIsiMateri.deskripsi" placeholder="Isi konten..."
                class="p-2 border rounded w-full mt-4" rows="5"></textarea>
            <button @click="addIsiMateri" class="mt-4 bg-green-500 text-white px-6 py-2 rounded hover:bg-green-600">
                Simpan Konten
            </button>
        </div>

        <div v-if="loading">Memuat konten...</div>
        <div v-else class="space-y-6">
            <div v-for="(item, index) in daftarIsiMateri" :key="item.id" class="border-b pb-6">

                <p v-if="item.kategoriMateri" class="text-sm text-gray-500 mb-2 font-semibold">
                    Kategori: {{ item.kategoriMateri.judul }}
                </p>

                <h4 class="text-xl font-semibold mb-2">Bab {{ index + 1 }}: {{ item.judul }}</h4>
                <img v-if="item.gambar" :src="item.gambar" class="rounded-lg mb-4 max-w-md w-full" alt="Gambar Konten">
                <p class="text-gray-700 whitespace-pre-wrap">{{ item.deskripsi }}</p>
                <button @click="deleteIsiMateri(item.id)" class="text-sm text-red-500 mt-2">Hapus Konten</button>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped></style>