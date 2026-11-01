<script setup>
  import { ref, onMounted } from "vue";
  import { supabase } from "../supabase.js";

  const emit = defineEmits(['materi-dipilih'])

  const daftarMateri = ref([]);
  const newMateri = ref({
    judul: "",
    thumbnail: "",
    deskripsi: "",
  });
  const loading = ref(true);

  onMounted(()=> {
    fetchMateri()
  });

  const fetchMateri = async () => {
    loading.value = true;
    const { data, error } = await supabase
      .from("kategoriMateri")
      .select("*")
      .order("created_at", { ascending: false });

    if (error) {
      console.error("Error fetching materi:", error);
    } else {
      daftarMateri.value = data;
    }
    loading.value = false;
  };

  const addMateri = async () => {
    if (!newMateri.value.judul || !newMateri.value.deskripsi) {
      alert("judul dan deskripsi tidak boleh kosong!");
      return;
    }
    const { data, error } = await supabase
      .from("kategoriMateri")
      .insert([
        {
          judul: newMateri.value.judul,
          thumbnail: newMateri.value.thumbnail,
          deskripsi: newMateri.value.deskripsi,
        },
      ])
      .select();

    if (error) {
      console.error("Error adding materi:", error);
    } else {
      daftarMateri.value.unshift(data[0]);
      newMateri.value = { judul: "", thumbnail: "", deskripsi: "" };
    }
  };

  const deleteMateri = async (id) => {
    if (
      !confirm(
        "Apakah anda yakin ingin menghapus materi ini? Menghapus inijuga akan menghapus semua isinya."
      )
    )
      return;

    const { error } = await supabase.from("kategoriMateri").delete().eq("id", id);

    if (error) {
      console.error("Error deleting materi:", error);
    } else {
      daftarMateri.value = daftarMateri.value.filter((m) => m.id !== id);
    }
  }

</script>

<template>
  <div class="p-8 max-w-4xl mx-auto">
    <h1 class="text-3xl font-bold mb-6">📚 Manajemen Materi</h1>

    <div class="bg-gray-100 p-4 rounded-lg mb-8">
      <h2 class="text-xl font-semibold mb-3">Tambah Materi Baru</h2>
      <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
        <input v-model="newMateri.judul" type="text" placeholder="Judul Materi" class="p-2 border rounded" />
        <input v-model="newMateri.thumbnail" type="text" placeholder="URL Thumbnail" class="p-2 border rounded" />
      </div>
      <textarea v-model="newMateri.deskripsi" placeholder="Deskripsi singkat" class="p-2 border rounded w-full mt-4"></textarea>
      <button @click="addMateri" class="mt-4 bg-blue-500 text-white px-6 py-2 rounded hover:bg-blue-600">
        Simpan Materi
      </button>
    </div>

    <div v-if="loading">Memuat data materi...</div>
    <div v-else class="space-y-4">
      <div 
        v-for="materi in daftarMateri" 
        :key="materi.id" 
        class="border rounded-lg p-4 flex justify-between items-center cursor-pointer hover:bg-gray-50"
        @click="emit('materi-dipilih', materi.id)"
      >
        <div class="flex items-center gap-4">
          <img :src="materi.thumbnail || 'https://via.placeholder.com/100'" alt="thumbnail" class="w-24 h-24 object-cover rounded">
          <div>
            <h3 class="text-lg font-bold">{{ materi.judul }}</h3>
            <p class="text-gray-600">{{ materi.deskripsi }}</p>
          </div>
        </div>
        <button @click.stop="deleteMateri(materi.id)" class="text-red-500 hover:text-red-700 font-bold">
          Hapus
        </button>
      </div>
    </div>
  </div>
</template>

<style></style>
