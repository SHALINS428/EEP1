import http from "@/http";

export default {
    select: {
        name: '类目查询',
        url: '/api/categories',
        /*
       async负责声明一个异步函数，它会返回一个Promise对象，可以使用 then 方法添加回调函数。
       只有async函数内部的异步操作执行完，才会执行then方法指定的回调函数。
       await责暂停服务异步的功能执行，进行等待.
       */
        /**
        * call 是自己起的一个方法
        * params: any = {} 如果传值就使用params传的为准 没有传值就是 ={} 相当于给了默认值
        */
        call: async function (params: any = {}) {
            return await http.get(this.url, params)
        }
    }
}