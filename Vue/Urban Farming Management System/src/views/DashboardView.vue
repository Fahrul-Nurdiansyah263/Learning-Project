<template>
  <div class="dashboard-container">
    <h1 class="welcome-header">
      Selamat Datang, {{ authStore.user?.username || authStore.user?.email }}!
    </h1>
    <p class="welcome-subheader">
      Ini adalah ringkasan kebun digital Anda. Mari kita mulai berkebun!
    </p>

    <div class="stats-grid">
      <div class="stat-card">
        <h3>Tanaman Aktif</h3>
        <p class="stat-number">{{ plantStore.plants.length }}</p>
      </div>
      <div class="stat-card">
        <h3>Tugas Pending</h3>
        <p class="stat-number">0</p>
        <small>(Fitur segera hadir)</small>
      </div>
    </div>

    <div class="actions-grid">
      <button class="action-button primary">➕ Tambah Tanaman Baru</button>
      <button class="action-button secondary">📝 Buat Postingan Baru</button>
    </div>

    <div class="plant-list-section">
      <h2>Daftar Tanaman Anda</h2>
      
      <div v-if="loading">Memuat data tanaman Anda...</div>

      <div v-else-if="!plantStore.plants.length" class="empty-state">
        <p>Anda belum memiliki tanaman. Ayo tambahkan yang pertama!</p>
        <button class="action-button primary small">➕ Tambah Tanaman</button>
      </div>

      <div v-else class="plant-grid">
        <div v-for="plant in plantStore.plants" :key="plant.id" class="plant-card">
          <h3>{{ plant.name }}</h3>
          <p class="species">{{ plant.species }}</p>
          <p class="date">Ditanam pada: {{ new Date(plant.planting_date).toLocaleDateString('id-ID') }}</p>
          <div class="plant-card-actions">
            <button class="button-small">Detail</button>
            <button class="button-small delete">Hapus</button>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useAuthStore } from '../stores/auth.js';
import { usePlantStore } from '../stores/plants.js';

const authStore = useAuthStore();
const plantStore = usePlantStore();
const loading = ref(true);

onMounted(async () => {
  loading.value = true;
  await plantStore.fetchPlants();
  loading.value = false;
});
</script>

<style scoped>
.dashboard-container {
  max-width: 960px;
  margin: 0 auto;
  padding: 2rem 1rem;
}

.welcome-header {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.welcome-subheader {
  color: #666;
  margin-bottom: 2rem;
}

.stats-grid, .actions-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1rem;
  margin-bottom: 2rem;
}

.stat-card {
  background-color: #f9f9f9;
  border: 1px solid #eee;
  border-radius: 8px;
  padding: 1.5rem;
  text-align: center;
}

.stat-number {
  font-size: 2.5rem;
  font-weight: bold;
  color: #2c3e50;
}

.action-button {
  padding: 1rem;
  border-radius: 8px;
  border: none;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: transform 0.2s;
}
.action-button:hover {
  transform: translateY(-2px);
}
.action-button.primary {
  background-color: #42b983;
  color: white;
}
.action-button.secondary {
  background-color: #e0e0e0;
  color: #333;
}
.action-button.small {
  padding: 0.5rem 1rem;
  font-size: 0.9rem;
}

.plant-list-section h2 {
  border-bottom: 2px solid #eee;
  padding-bottom: 0.5rem;
  margin-bottom: 1.5rem;
}

.plant-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 1rem;
}

.plant-card {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 1rem;
  display: flex;
  flex-direction: column;
}
.plant-card .species {
  color: #777;
  font-style: italic;
}
.plant-card .date {
  font-size: 0.9em;
  color: #555;
  margin-top: auto;
  padding-top: 1rem;
}
.plant-card-actions {
  display: flex;
  gap: 0.5rem;
  margin-top: 1rem;
}
.button-small {
  padding: 0.4rem 0.8rem;
  border: 1px solid #ccc;
  background-color: white;
  border-radius: 4px;
  cursor: pointer;
}
.button-small.delete {
  border-color: #e57373;
  color: #e57373;
}
</style>