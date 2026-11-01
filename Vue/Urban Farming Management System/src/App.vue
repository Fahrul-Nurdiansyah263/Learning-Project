<template>
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      <template v-if="authStore.user">
        <RouterLink to="/dashboard">Dashboard</RouterLink>
        <span>Hello, {{ authStore.user.email }}</span>
        <button @click="handleLogout">Logout</button>
      </template>
      <template v-else>
        <RouterLink to="/login">Login</RouterLink>
        <RouterLink to="/register">Register</RouterLink>
      </template>
    </nav>
  </header>
  <main>
    <RouterView />
  </main>
</template>

<script setup>
import { onMounted } from 'vue'
import { RouterLink, RouterView, useRouter } from 'vue-router'
import { useAuthStore } from './stores/auth'

const authStore = useAuthStore()
const router = useRouter()

onMounted(() => {
  authStore.fetchUser()
})

async function handleLogout() {
  await authStore.signOut()
  router.push({ name: 'Login' })
}
</script>

<style scoped>
nav { display: flex; gap: 1rem; padding: 1rem; border-bottom: 1px solid #ccc; }
</style>