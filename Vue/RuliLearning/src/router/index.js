import { createRouter, createWebHistory } from "vue-router";
import kategoriMateri from '../views/KategoriMateri.vue'
import IsiMateri from '../views/IsiMateri.vue'

const routes = [
    {path: '/kategori-materi', component: kategoriMateri},
    {path: '/isi-materi', component: IsiMateri, props: true, name:'IsiMateri'},
]

const router = createRouter({
    history:createWebHistory(),
    routes
})

export default router