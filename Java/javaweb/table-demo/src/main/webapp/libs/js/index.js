new Vue({
    el:"#app",
    mounted() {
        let _that = this;
        axios.get('/brands').then(function (response) {
            if (response.status === 200) {
                _that.tableData = response.data
            }
        }).catch(function (error) {
            console.log(error)
        })
    },
    methods: {
        tableRowClassName({row, rowIndex}) {
            if (rowIndex === 1) {
                return 'warning-row';
            } else if (rowIndex === 3) {
                return 'success-row';
            }
            return '';
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
            console.log(this.multipleSelection)
        }
    },
    data() {
        return {
            tableData: [],
            // tableData: [{
            //     date: '2016-05-02',
            //     name: '王小虎',
            //     address: '上海市普陀区金沙江路 1518 弄',
            // }, {
            //     date: '2016-05-04',
            //     name: '王小虎',
            //     address: '上海市普陀区金沙江路 1518 弄'
            // }, {
            //     date: '2016-05-01',
            //     name: '王小虎',
            //     address: '上海市普陀区金沙江路 1518 弄',
            // }, {
            //     date: '2016-05-03',
            //     name: '王小虎',
            //     address: '上海市普陀区金沙江路 1518 弄'
            // }],
            multipleSelection: []
        }
    }
})

// const axios = require('axios').default;



