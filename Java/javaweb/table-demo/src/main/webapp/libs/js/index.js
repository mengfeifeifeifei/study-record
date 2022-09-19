new Vue({
    el:"#app",
    mounted() {
        this.getBrandList()
    },
    methods: {
        tableRowClassName({row, rowIndex}) {
            if (rowIndex % 2 === 0) {
                return 'warning-row';
            }
            // } else if (rowIndex === 3) {
            //     return 'success-row';
            // }
            return '';
        },
        handleSelectionChange(val) {
            this.multipleSelection = []
            for (let i = 0; i < val.length; i++) {
                this.multipleSelection.push(val[i].id);
            }
            this.disabled = this.multipleSelection.length === 0;

            console.log(this.multipleSelection)
        },
        batchDelete() {
            axios.post('brand/batchDelete', {
                ids: this.multipleSelection
            }).then((resp) => {
                console.log(resp)
                this.getBrandList()
                this.delMessage()
            }).catch((error) => {
                console.log(error)
                this.failMessage()
            })
        },
        onSubmit() {
            this.getBrandList();
            console.log('submit!');
        },
        addSubmit() {
            let _that = this
            axios.post('/brand/addBrand', {
                name: this.form.name,
                company: this.form.company,
                sort: this.form.sort,
                status: this.form.status
            }).then(function (response) {
                if (response.status === 200) {
                    _that.dialogFormVisible = false
                    _that.successMessage()
                    _that.getBrandList()
                    // _that.tableData = response.data
                }
            }).catch(function (error) {
                console.log(error)
            })
        },
        getBrandList() {
            let _that = this;
            let url = '/brand/selectAll?page=' + _that.currentPage + '&limit=' + _that.limit;
            if (this.formInline.name !== '') {
                url += '&name=' + this.formInline.name
            }
            if (this.formInline.status !== '') {
                url += '&status=' + this.formInline.status
            }
            if (this.formInline.company !== '') {
                url += '&company=' + this.formInline.company
            }
            axios.get(url).then(function (response) {
                if (response.status === 200) {
                    _that.tableData = response.data.data
                    _that.totalCount = response.data.totalCount
                }
            }).catch(function (error) {
                this.failMessage()
                console.log(error)
            })
        },
        successMessage(){
            this.$message({
                message: '添加成功',
                type: 'success'
            });
        },
        updateMessage(){
            this.$message({
                message: '修改成功',
                type: 'success'
            });
        },
        delMessage(){
            this.$message({
                message: '删除成功',
                type: 'success'
            });
        },
        failMessage(){
            this.$message.error('出错了出错了！');
        },
        getCurrentPage(val){
            this.currentPage = val
            this.getBrandList()
        },
        // handleStatus(row, column, cellValue, index){
        //     switch (cellValue) {
        //         case 1:
        //             return '开启';
        //         case 0:
        //             return '关闭';
        //     }
        // },
        handleEdit(index, row) {
            this.formUpdate.id = row.id
            this.formUpdate.name = row.name
            this.formUpdate.company = row.company
            this.formUpdate.status = row.status
            this.formUpdate.sort = row.sort
            this.dialogFormVisibleUpdate = true
        },
        handleDelete(index, row) {
            axios.delete('/brand/delBrand?id=' + row.id).then((response) => {
                if (response.status === 200) {
                    console.log(response)
                    this.delMessage();
                    this.getBrandList()
                }
            }).catch((error) => {
                this.failMessage();
                console.log(error)
            })
            console.log(index, row);
        },
        updateSubmit() {
            console.log(this.formUpdate)
            axios.post('/brand/updateBrand', this.formUpdate).then((response)=>{
                if (response.status === 200) {
                    this.dialogFormVisibleUpdate = false
                    this.getBrandList()
                    this.updateMessage()
                }
            }).catch((error) => {
                this.failMessage()
                console.log(error)
            })
        }
    },
    data() {
        return {
            tableData: [],
            multipleSelection: [],
            formInline: {
                name: '',
                company: '',
                status: '',
            },
            // dialogTableVisible: false,
            dialogFormVisible: false,
            dialogFormVisibleUpdate: false,
            // 新增的form数据
            form: {
                name: '',
                company: '',
                status: 1,
                sort: ''
            },
            // 修改form数据
            formUpdate: {
                id: '',
                name: '',
                company: '',
                status: 1,
                sort: ''
            },
            formLabelWidth: '120px',
            currentPage: 1,
            limit: 10,
            totalCount: 0,
            disabled: true
        }
    }
})

// const axios = require('axios').default;



