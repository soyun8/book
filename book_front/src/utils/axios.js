import axios from 'axios'

const instance = axios.create({
    // baseURL: process.env.VUE_APP_URI,
    baseURL: 'http://52.78.150.161:8080/',
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
