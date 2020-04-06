/**
 *  Access Control Permission
 */
import router from './router'
import { getToken } from '@/utils/auth'

const whiteList = ['/login'];

router.beforeEach(async (to, from, next) => {

  const hasToken = getToken();
  console.log(hasToken)
  if (hasToken) {

  } else {
    if (whiteList.indexOf(to.path) !== -1) {
      // in the whitelist, go directly
      next()
    } else {
      next(`/login?redirect=${to.path}`)
    }
  }

});

router.afterEach(() => {
  // finish progress bar
})
