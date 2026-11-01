import { createClient } from '@supabase/supabase-js'

const supabaseUrl = 'https://sqrplrkafjzrwhymuxdf.supabase.co'
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InNxcnBscmthZmp6cndoeW11eGRmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTYzNDg5NjIsImV4cCI6MjA3MTkyNDk2Mn0.m-3vr1USgo2e5P8dITDau1oqT6ANg7eug-jecoW4rwE'

export const supabase = createClient(supabaseUrl, supabaseKey)