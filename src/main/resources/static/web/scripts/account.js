Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            account: {},
            transactions:{}
        }
    },
    created() {
        const urlParams = new URLSearchParams(window.location.search);
        const idAccount = urlParams.get('id');

        axios.get('http://localhost:8080/api/accounts/'+idAccount)
            .then(data => {
                this.account = data.data
                this.transactions = data.data.transactions
                this.sortTransactions()
                console.log(this.transactions)
            });

    },
    methods: {
        formatDate(dateInput) {
            const date = new Date(dateInput)
            return (date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear() + " " +
                            date.getHours() + ":" + (date.getMinutes() > 9 ? date.getMinutes() : "0" + date.getMinutes()))
        },
        sortTransactions(){
          this.transactions.sort((a,b) => b.id - a.id)
        },
    },
    computed: {},
}).mount('#app')