<template>
  <div class="flex-shrink-0 w-64 h-screen bg-gray-100 border-r border-gray-200">
    <div class="p-5">
      <h2 class="text-2xl font-bold mb-5">Admin Menu</h2>
      <nav>
        <ul>
          <li class="my-4">
            <router-link
              to="/kategori-materi"
              class="font-semibold text-gray-700 hover:text-green-500 transition-colors"
            >
              Kategori Materi
            </router-link>
          </li>
          <li class="my-4">
            <router-link
              to="/isi-materi"
              class="font-semibold text-gray-700 hover:text-green-500 transition-colors"
            >
              Isi Materi
            </router-link>
          </li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Sidebar'
}
</script>

<style scoped>
/* Vue Router secara otomatis menambahkan class .router-link-exact-active
  pada link yang sedang aktif. Kita bisa men-style class ini secara khusus.
  @apply adalah fitur Tailwind untuk menerapkan utility classes di dalam CSS.
*/

</style>