import Vue from 'vue';
import Router from 'vue-router';
import routerConfig from '@/config/routes';

Vue.use(Router);

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: routerConfig
})

const router = createRouter()

export default router

// export default new Router({
//   routes: routerConfig,
// });
