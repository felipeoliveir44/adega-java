import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/funcionario',
      name: 'funcionario',
      component: () => import('../views/FuncionarioView.vue')
    },
    {
      path: '/estoque',
      name: 'estoque',
      component:() => import('../views/EstoqueView.vue')
    },
    {
      path: '/pdv',
      name: 'pdv',
      component:() => import('../views/PdvView.vue')
    }
  ]
})

export default router
