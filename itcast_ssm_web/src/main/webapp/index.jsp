<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<div style="color: red;text-align: center">
    <h2>后台管理页面</h2>
    <p>
        <span id="time">3</span>秒之后,自动跳转首页...
    </p>

</div>

<script>
    //获取倒计时秒数
    var time = document.getElementById("time");
    var second = 3;
    function showTime(){
        second -- ;
        if(second <= 0){
            //时间到了，跳转首页
            location.href = "${pageContext.request.contextPath}/main";
        }
        time.innerHTML = second;
    }
    setInterval(showTime,500);
</script>
</body>
</html>
