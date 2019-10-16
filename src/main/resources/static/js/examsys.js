$(function () {
    $.ajax({
        type: 'GET',
        url: 'http://127.0.0.1:8080/examsys/menu/rootMenu.do',
        dataType: 'JSON', //如果后台本来返回的就是Json数据则可以省略
        success: function (result) {

            $(result.data).each(function (i) {
                var url = "http://127.0.0.1:8080/examsys"+ this.menuUrl+"?menuId="+this.menuId+"";
                var str = "<li class='layui-nav-item'><a class='rootMenus'  href='"+url+"'>" + this.menuName + "</a></li>";
                var a = $(str);
                a.appendTo($("#rootMenu"))
            })
        }

    });

});
//
// $(document).on('click','rootMenus',function(url){
//     alert("fffff");
//     $.ajax({
//         type: 'GET',
//         url: url,
//         dataType: 'JSON', //如果后台本来返回的就是Json数据则可以省略
//         success: function (result) {
//             if (result.code == 0){
//                 $("#leftMenu").empty();
//                 $(result.data.menus).each(function (i) {
//                     var str = "<li class='layui-nav-item'><a  href='javascript:;' onclick='myfunction(" + 'http://127.0.0.1:8080/examsys' + this.menuUrl + '?menuId='+this.menuId+")'>" + this.menuName + "</a></li>";
//                     var a = $(str);
//                     a.appendTo($("#rootMenu"))
//                 })
//             }else {
//                 alert(result.data.message);
//             }
//         },
//         error: function () {
//             alert("内部出错！");
//         }
//     });
// });

// function myfunction(url) {
//     $.ajax({
//         type: 'GET',
//         url: url,
//         dataType: 'JSON', //如果后台本来返回的就是Json数据则可以省略
//         success: function (result) {
//             if (result.code == 0){
//                 $("#leftMenu").empty();
//                 $(result.data.menus).each(function (i) {
//                     var str = "<li class='layui-nav-item'><a  href='javascript:;' onclick='myfunction(" + 'http://127.0.0.1:8080/examsys' + this.menuUrl + '?menuId='+this.menuId+")'>" + this.menuName + "</a></li>";
//                     var a = $(str);
//                     a.appendTo($("#rootMenu"))
//                 })
//             }else {
//                 alert(result.data.message);
//             }
//         },
//         error: function () {
//             alert("内部出错！");
//         }
//     });
// }