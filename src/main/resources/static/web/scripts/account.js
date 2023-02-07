Vue.createApp({
    data() {
        return {
            message: 'Hello Vue!',
            accounts: [],
            account: {},
            urlAccountSelected: "",
            accountSelected: {},
            contenidoJson: [],
            transactions:{}

            number: "",
            creationData: "",
            balance: "",
            client: ""
        }
    },

    created() {
        axios.get('http://localhost:8080/rest/accounts')
            .then(datos => {
                this.accounts = datos.data._embedded.accounts
                this.contenidoJson = datos.data
                console.log(this.accounts)
            })
        axios.get('http://localhost:8080/rest/transactions')
        .the(datos => {
            this.transactions = datos.data._embedded.transactions
            this.contenidoJson = datos.data
            console.log(this.transactions)
        })
    },
    methods: {
        captureAccount(account) {
            this.accountSelected = account;
            this.urlAccountSelected = account._links.client.href;
        },
    },
    computed: {},
}).mount('#app')