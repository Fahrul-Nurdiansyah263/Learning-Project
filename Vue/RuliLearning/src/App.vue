<template>
  <div id="app-layout" class="flex">
    <Sidebar />
  
  </div>
</template>

<script>

import Sidebar from './components/Sidebar.vue';

export default {
  components: {
    Sidebar
  }
}
</script>


  
    <main class="flex-grow p-8">
      <router-view/>
    </main>