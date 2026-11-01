
<script setup>
import { ref, onMounted } from "vue";
import { supabase } from "../supabase.js";

const daftarUser = ref([]);
const loading = ref(true);

onMounted(() => {
  fetchMateri();
});

const fetchMateri = async () => {
  loading.value = true;
  const { data, error } = await supabase
    .from("pengguna")
    .select("*")
    .order("created_at", { ascending: false });

  if (error) {
    console.error("Error fetching data pengguna:", error);
  } else {
    daftarUser.value = data;
  }
  loading.value = false;
};


export default {
  name: 'Pengguna'
}
</script>


<template>
  <div class="container">
    <h1>Daftar Pengguna</h1>

    <div v-if="loading" class="loading">
      <p>Memuat data pengguna...</p>
    </div>

    <div v-else>
      <div v-if="daftarUser.length === 0" class="no-data">
        <p>Tidak ada data pengguna yang ditemukan.</p>
      </div>

      <table v-else class="user-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nama</th>
            <th>Email</th>
            <th>Tanggal Dibuat</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in daftarUser" :key="user.id">
            <td>{{ user.id }}</td>
            <td>{{ user.nama }}</td>
            <td>{{ user.email }}</td>
            <td>{{ new Date(user.created_at).toLocaleDateString("id-ID") }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
