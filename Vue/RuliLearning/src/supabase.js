import { createClient } from '@supabase/supabase-js'

const supabaseUrl = 'https://eudfvcjeuppvkjgqkqlv.supabase.co'
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV1ZGZ2Y2pldXBwdmtqZ3FrcWx2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTU5MTU5NDYsImV4cCI6MjA3MTQ5MTk0Nn0.D0MQNWPeZeR07GL9t3nbkDsTOLc0d04r7wRx4c9BH4k'
export const supabase = createClient(supabaseUrl, supabaseKey)