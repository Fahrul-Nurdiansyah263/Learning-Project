import { defineStore } from 'pinia'
import { ref } from 'vue'
import { supabase } from '../supabase'

export const usePostStore = defineStore('posts', () => {
  const posts = ref([])

  async function fetchPosts() {
    const { data, error } = await supabase
      .from('posts')
      .select(`
        *,
        profiles (
          username,
          role_id ( name )
        )
      `)
      .order('created_at', { ascending: false }) 
      .limit(20) 

    if (error) {
      console.error('Error fetching posts:', error.message)
    } else {
      const cleanedData = data.map(post => ({
        ...post,
        author_username: post.profiles.username,
        author_role: post.profiles.role_id.name,
        profiles: undefined, 
      }))
      posts.value = cleanedData
    }
  }

  return { posts, fetchPosts }
})