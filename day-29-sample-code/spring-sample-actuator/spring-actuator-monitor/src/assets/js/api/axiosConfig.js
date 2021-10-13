import axios from 'axios'
const instance = () => {
  const baseURL = 'http://localhost:8080/sea'
  const timeout = 100000
  const headers = {
    'Content-Type': 'application/json'
  }
  const service = axios.create({
    baseURL,
    timeout,
    headers
  })
  return service
}
export { instance }
export default instance()
