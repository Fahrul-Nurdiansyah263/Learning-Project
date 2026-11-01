
import { defineStore } from 'pinia'
import { ref } from 'vue'
import { supabase } from'../supabase.js';
import { useAuthStore } from './auth.js'

export const usePlantStore = defineStore('plants', () => {
  const authStore = useAuthStore()
  
  const plants = ref([])

  
  async function fetchPlants() {
    if (!authStore.user) {
      console.error('User belum login, tidak bisa mengambil data tanaman.')
      return
    }
    
    const { data, error } = await supabase
      .from('plants')
      .select('*')
      .eq('user_id', authStore.user.id)
      .order('created_at', { ascending: false })
      
    if (error) {
      console.error('Error fetching plants:', error.message)
    } else {
      plants.value = data
    }
  }

  async function addPlant(plantData) {
    if (!authStore.user) throw new Error('User not logged in')
    
    const { data, error } = await supabase
      .from('plants')
      .insert({
        ...plantData,
        user_id: authStore.user.id
      })
      .select()
      .single()

    if (error) {
      console.error('Error adding plant:', error.message)
      return null
    }
    
    plants.value.unshift(data)
    return data
  }
  
  async function deletePlant(plantId) {
    const { error } = await supabase
      .from('plants')
      .delete()
      .eq('id', plantId)
      
    if (error) {
      console.error('Error deleting plant:', error.message)
      return
    }
    
    plants.value = plants.value.filter(p => p.id !== plantId)
  }
  

  return { plants, fetchPlants, addPlant, deletePlant }
})