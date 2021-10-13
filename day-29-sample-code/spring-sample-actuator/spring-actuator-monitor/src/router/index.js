import Vue from 'vue'
import Router from 'vue-router'
import BeanPage from '@/components/beans/BeanPage'
import HealthPage from '@/components/beans/HealthPage'
import MemoryPage from '@/components/beans/MemoryPage'
import InfoPage from '@/components/beans/InfoPage'
import ScheduledPage from '@/components/beans/ScheduledPage'
import EnvPage from '@/components/beans/EnvironmentPage'
import MetricsPage from '@/components/beans/MetricsPage'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'InfoPage',
      component: InfoPage
    },
    {
      path: '/health',
      name: 'Health',
      component: HealthPage
    },
    {
      path: '/memory',
      name: 'Memory',
      component: MemoryPage
    },
    {
      path: '/beans',
      name: 'Beans',
      component: BeanPage
    },
    {
      path: '/scheduled',
      name: 'Scheduled',
      component: ScheduledPage
    },
    {
      path: '/environment',
      name: 'Environment',
      component: EnvPage
    },
    {
      path: '/metrics',
      name: 'Metrics',
      component: MetricsPage
    }
  ]
})
