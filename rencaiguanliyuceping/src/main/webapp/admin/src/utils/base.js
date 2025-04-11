const base = {
    get() {
        return {
            url : "http://localhost:8080/rencaiguanliyuceping/",
            name: "rencaiguanliyuceping",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/rencaiguanliyuceping/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "企业人才管理与测评系统"
        } 
    }
}
export default base
