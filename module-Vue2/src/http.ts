import axios from 'axios'

// 集中配置：基地址 + 超时。注意 baseURL 用相对路径 '/api'，交给 Vite 代理转发
export const http = axios.create({ baseURL: '/api', timeout: 5000 })

// 用户数据类型
export interface User { name: string; age: number }

// GET：拿数据（列表）
export function fetchUsers() {
  return http.get('/users')    // 调用方 await 后取 res.data，不用再 .json()
}

// POST：提交（新增）
export function createUser(data: User) {
  return http.post('/users', data)
}
