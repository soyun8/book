import axios from 'axios'

const baseURL = 'http://localhost:8080'

const instance = axios.create({
    baseURL: baseURL,
    timeout: 5000,
    headers: {
        Accept: 'application/json',
    },
})

instance.interceptors.request.use(
    (config) => {
        return config
    },
    (error) => {
        return Promise.reject(error)
    },
)

instance.interceptors.response.use(
    (res) => {
        return res.data
    },
    (error) => {
        return Promise.reject(error)
    },
)

const axiosComm = async (req) => {
    try {
        const method = req.method || 'get'
        const config = {
            url: req.url,
            method,
            params: method === 'get' ? req.params : undefined,
            data: method !== 'get' ? req.data : undefined,
            timeout: req.timeout || 5000
        }

        return await instance(config)
    } catch (e) {
        if (e.response) {
            throw e.response.data
        } else {
            console.error(e.message)
            throw e.message
        }
    }
}


export default axiosComm
