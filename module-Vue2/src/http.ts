import axios from 'axios'

// 集中配置：基地址 + 超时。注意 baseURL 用相对路径 '/api'，交给 Vite 代理转发
const http = axios.create({ baseURL: '/api', timeout: 5000 })

// // GET：拿数据（列表）
// const res = await http.get('/users')
// console.log(res.data)          // 数据在 res.data，不用再 .json()
//
// // POST：提交（新增）
// await http.post('/users', { name: '小明', age: 20 })

export default http