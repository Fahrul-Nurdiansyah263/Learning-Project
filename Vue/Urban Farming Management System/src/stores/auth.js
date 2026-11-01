import { defineStore } from 'pinia'
import { ref } from 'vue'
import { supabase } from '../supabase'

export const useAuthStore = defineStore('auth', () => {
  const user = ref(null) 
  async function fetchUser() {
    const { data: sessionData } = await supabase.auth.getSession()
    if (sessionData.session) {
      const { data: profileData } = await supabase
        .from('profiles')
        .select('*, roles(name)') 
        .eq('id', sessionData.session.user.id)
        .single()
      if (profileData) {
        user.value = {
          ...profileData,
          email: sessionData.session.user.email
        }
        user.value.role = profileData.roles.name
        delete user.value.roles
      }
    }
  }
  
  async function signUp(credentials) {
    const { data: rolesData } = await supabase.from('roles').select('id').eq('name', credentials.role).single()
    if (!rolesData) throw new Error('Role not found')

    const { data, error } = await supabase.auth.signUp({
      email: credentials.email,
      password: credentials.password,
      options: {
        data: {
          role_id: rolesData.id
        }
      }
    })
    if (error) throw error
    return data
  }

  async function signIn(credentials) {
    const { data, error } = await supabase.auth.signInWithPassword({
      email: credentials.email,
      password: credentials.password,
    })
    if (error) throw error
    await fetchUser()
    return data
  }

  async function signOut() {
    const { error } = await supabase.auth.signOut()
    if (error) throw error
    user.value = null
  }

  return { user, fetchUser, signUp, signIn, signOut }
})