import axios from 'axios'


// create an axios instance
const service = new axios({
  baseURL: '',
  timeout: 5000
});

// request interceptor
service.interceptors.request.use();

// response interceptor
service.interceptors.response.use(
  response => {
    const res = response.data
  },
  error => {

  }
);

export default service
