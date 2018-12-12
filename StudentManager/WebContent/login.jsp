<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="../js/jquery-1.11.3.js"></script>

<link rel="stylesheet" type="text/css" href="./css/test.css" />
<title>test</title>
<h1>Hellow world! 1</h1>
<h2>Hellow world! 2</h2>
<h3>Hellow world! 3</h3>
<h4>Hellow world! 4</h4>
<h5>Hellow world! 5</h5>
<h6>Hellow world! 6</h6>
<a href="http://www.baidu.com">百度</a>


<table cellspacing="0px" cellspadding="0px" width="300px">
	<tr>
		<td rowspan="3" width="100px">ID</td>
		<td width="100px">名前</td>
		<td width="100px">クラスID</td>
	</tr>
	<tr>
		<td>田中</td>
		<td>67</td>
	</tr>
	<tr>

		<td>山田</td>
		<td>68</td>
	</tr>
	<tr>
		<td colspan="2">私は二つrow</td>
		<td>aaa</td>
	</tr>
</table>

</head>
<body>
<form>
<input id="inputid" type="text"><p>username</p>
</form>
<a id="ajaxbtn" href="javascript:void(0);">hello</a>
<script type="text/javascript">
		$(function(){
			$('#ajaxbtn').click(function(){
				var ajaxUrl = 'myajax';
				var username = $("#inputid").val();
				var param = {id:username};
				$.getJSON(ajaxUrl,param,function(result){
					if(!result.result){
						alert('接口失敗');
						return false;
					}else{
						alert("接口成功");
					};
					var data = result.data;
					var html = "<div>"
					for(var i=0;i<data.length;i++){
						html+="<span>id："+data[i].id+"</span><br>"
						html+="<span>名字："+data[i].name+"</span><br>"
						html+="<span>年齡："+data[i].age+"</span><br>"
						html+="<span>分数："+data[i].score+"</span><br>"

					}
					html+='</div>'
					$("body").append(html);
				//	$("#inputid").hide();
					//$("#inputpsd").hide();
				//	$("#but").hide();
					//$("body").css('background-color','green');
				});
			});
		});
	</script>
</script>
</body>
</html>

