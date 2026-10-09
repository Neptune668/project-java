import {defineStore} from "pinia";

export const userStore = defineStore('count',{
    state:()=>({
        count:0
    }),
    actions:{
        increment(){
            this.count++
        }
    }
});