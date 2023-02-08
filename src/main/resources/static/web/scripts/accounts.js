Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            client:{},
            accounts:{}
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const idClient = urlParams.get('id');

        axios.get('http://localhost:8080/api/accounts/')
            .then(data => {
                //this.client = data.data
                this.accounts = data.data
                this.sortAccounts()
            });

    },
    methods: {
        formatDate(dateInput) {
            const date = new Date(dateInput)
            return (date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " +
                            date.getHours() + ":" + (date.getMinutes() > 9 ? date.getMinutes() : "0" + date.getMinutes()))
        },
        sortAccounts(){
            this.accounts.sort((a,b) => a.id - b.id)
        },
        path(account){
            return "/web/account.html?id="+account.id
        },
    },
    computed: {},
}).mount('#app')