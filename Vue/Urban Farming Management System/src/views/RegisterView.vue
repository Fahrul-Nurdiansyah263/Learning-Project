<template>
  <div class="min-h-screen bg-gray-100 flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8">
    <div class="w-full max-w-md space-y-8 bg-white p-10 rounded-xl shadow-lg">
      <div>
        <h2 class="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900">
          Buat Akun Baru
        </h2>
        <p class="mt-2 text-center text-sm text-gray-600">
          Mari bergabung dengan komunitas Urban Farming!
        </p>
      </div>

      <form class="mt-8 space-y-6" @submit.prevent="handleRegister">
        
        <div class="rounded-md shadow-sm -space-y-px">
          <div>
            <label for="email-address" class="sr-only">Email</label>
            <input id="email-address" v-model="email" name="email" type="email" required
              class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-green-500 focus:outline-none focus:ring-green-500 sm:text-sm"
              placeholder="Alamat Email">
          </div>
          <div>
            <label for="password" class="sr-only">Password</label>
            <input id="password" v-model="password" name="password" type="password" required
              class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-green-500 focus:outline-none focus:ring-green-500 sm:text-sm"
              placeholder="Password (minimal 6 karakter)">
          </div>
        </div>
        
        <div>
          <label for="role" class="block text-sm font-medium text-gray-700">Saya ingin mendaftar sebagai:</label>
          <select id="role" v-model="role" name="role" required
            class="mt-1 block w-full rounded-md border-gray-300 py-2 pl-3 pr-10 text-base focus:border-green-500 focus:outline-none focus:ring-green-500 sm:text-sm">
            <option value="farmer">Farmer (Petani)</option>
            <option value="agronomist">Agronomist (Ahli Agronomi)</option>
          </select>
          <p class="mt-2 text-xs text-gray-500">
            Peran Admin tidak bisa dipilih saat pendaftaran.
          </p>
        </div>

        <div v-if="successMsg" class="rounded-md bg-green-50 p-4">
          <p class="text-sm font-medium text-green-800">{{ successMsg }}</p>
        </div>
        <div v-if="errorMsg" class="rounded-md bg-red-50 p-4">
          <p class="text-sm font-medium text-red-800">{{ errorMsg }}</p>
        </div>

        <div>
          <button type="submit" :disabled="loading"
            class="group relative flex w-full justify-center rounded-md border border-transparent bg-green-600 py-2 px-4 text-sm font-medium text-white hover:bg-green-700 focus:outline-none focus:ring-2 focus:ring-green-500 focus:ring-offset-2 disabled:bg-green-300">
            {{ loading ? 'Mendaftarkan...' : 'Daftar' }}
          </button>
        </div>
      </form>
    </div>
    
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { useAuthStore } from '../stores/auth.js';

const authStore = useAuthStore();
const router = useRouter();

const email = ref('');
const password = ref('');
const role = ref('farmer'); 
const loading = ref(false);
const errorMsg = ref(null);
const successMsg = ref(null);

async function handleRegister() {
  loading.value = true;
  errorMsg.value = null;
  successMsg.value = null;
  try {
    await authStore.signUp({
      email: email.value.trim(),
      password: password.value,
      role: role.value,
    });
    successMsg.value = 'Registrasi berhasil! Silakan cek email Anda untuk verifikasi. Anda akan diarahkan ke halaman Login.';
    setTimeout(() => {
      router.push({ name: 'Login' });
    }, 3000); 
  } catch (error) {
    errorMsg.value = error.message;
  } finally {
    loading.value = false;
  }
}
</script>