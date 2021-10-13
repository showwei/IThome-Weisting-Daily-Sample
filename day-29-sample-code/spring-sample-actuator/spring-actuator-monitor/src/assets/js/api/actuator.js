import axiosInstance from './axiosConfig'

const getActuator = () => axiosInstance.get('/actuator')

const getServiceMemoryUsage = () => axiosInstance.get('/actuator/memory')

const getServiceInformation = () => axiosInstance.get('/actuator/info')

const getServiceHealth = () => axiosInstance.get('/actuator/health')

const getServiceBeans = () => axiosInstance.get('/actuator/beans')

const getServiceSchedulers = () => axiosInstance.get('/actuator/scheduledtasks')

const getServiceMetrics = () => axiosInstance.get('/actuator/metrics')

const getServiceEnvironment = () => axiosInstance.get('/actuator/env')

const getServiceMetricsByName = (requiredMetricName) => axiosInstance.get(`/actuator/metrics/${requiredMetricName}`)
export {
  getActuator,
  getServiceMemoryUsage,
  getServiceInformation,
  getServiceHealth,
  getServiceBeans,
  getServiceSchedulers,
  getServiceMetrics,
  getServiceEnvironment,
  getServiceMetricsByName
}
