
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/test.css" />
<style type="text/css"></style>
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#buttonsearchbyname").click(function(){
	var input_searchbyname=$("#inputsearchbyname").val();
	if(input_searchbyname==""||input_searchbyname==null){
		alert("请输入学生姓名");
		return false;
	}else{
		$("#formsearchbyname").submit();
	}
	})
})
$(document).ready(function(){
	$("#buttonsearchbyid").click(function(){
	var input_searchbyid=$("#inputsearchbyid").val();
	if(input_searchbyid==""||input_searchbyid==null){
		alert("请输入学生id");
		return false;
	}else{
		$("#formsearchbyid").submit();
	}
	})
})

$(document).ready(function(){
	$("#buttonaddstudent").click(function(){
	var input_addname=$("#addname").val();
	var studentname = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
	if(input_addname==""||input_addname==null){
		alert("请输入学生姓名");
		return false;
	}else{
		if(!studentname.test($("#addname").val())){
			alert("姓名只能输入日文和英文");
			return false;
		}
	}
	var input_addbirthday=$("#addbirthday").val();
	if(input_addbirthday==""||input_addbirthday==null){
		alert("请输入学生生日");
		return false;
	}
	var input_addage=$("#addage").val();
	if(input_addage==""||input_addage==null){
		alert("请输入学生年龄");
		return false;
	}
	var input_addscore=$("#addscore").val();
	if(input_addscore==""||input_addscore==null){
		alert("请输入学生分数");
		return false;
	}

	$("#addForm").submit();
	})
})

$(document).ready(function(){
	$("#buttondelbyid").click(function(){
	var input_delbyid=$("#delid").val();
	if(input_delbyid==""||input_delbyid==null){
		alert("请输入要删除学生的id");
		return false;
	}else{
		$("#delForm").submit();
	}
	})
})
$(document).ready(function(){
	$("#buttondelbyname").click(function(){
	var input_delbyname=$("#delname").val();
	if(input_delbyname==""||input_delbyname==null){
		alert("请输入要删除学生的姓名");
		return false;
	}else{
		$("#delnameForm").submit();
	}
	})
})

$(document).ready(function(){
	$("#editstudentid").click(function(){
		if(input_editid==""||input_editid==null){
			alert("请输入要编辑的学生id");
			return false;
		}else{
			alert("请输入新的学生信息");
			$("#editstudent").click(function(){
				var input_addname=$("#editname").val();
				var studentname = /^[\u3040-\u309F\u30A0-\u30FF\u4e00-\u9fa5A-Za-z]+$/;
				if(input_editname==""||input_editname==null){
					alert("请输入学生姓名");
					return false;
				}else{
					if(!studentname.test($("#editname").val())){
						alert("姓名只能输入日文和英文");
						return false;
					}
				}
				var input_editbirthday=$("#editbirthday").val();
				if(input_editbirthday==""||input_editbirthday==null){
					alert("请输入学生生日");
					return false;
				}
				var input_editage=$("#editage").val();
				if(input_editage==""||input_editage==null){
					alert("请输入学生年龄");
					return false;
				}
				var input_editscore=$("#editscore").val();
				if(input_editscore==""||input_editscore==null){
					alert("请输入学生分数");
					return false;
				}
				$("#addForm").submit();
			})

		}

	})
})


</script>
</head>
<body>
	<img src="./images/header.jpg" /> ${msg}
	<h1 align="center">学员信息管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center">学员信息一览</h2>
		<table id="items"  cellspacing="0px" cellspadding="0px" width="400px">
			<tr>
				<td>id</td>
				<td width="100px">姓名</td>
				<td width="100px">出生年月</td>
				<td width="50px">年龄</td>
				<td width="100px">分数</td>
			</tr>

			<c:forEach items="${students}" var="student">
				<tr>
					<td id="id${student.id }">${student.id}</td>
					<td id="name${student.id }">${student.name}</td>
					<td id="birthday${student.id}">${student.birthday}</td>
					<td id="age${student.id }">${student.age}</td>
					<td id="score${student.id}">${student.score}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="add_comm" class="all" align="center">
			<h2>学生の検索</h2>
			<form id="formsearchbyname" action="queryByName" method="post">
				<input id="inputsearchbyname"type="text" placeholder="氏名" name="name">
				<button id="buttonsearchbyname" type="button" >
				<p>学生の検索</p>
				</button>
			</form>
			<form id="formsearchbyid" action="queryById" method="post">
				<input id="inputsearchbyid"type="text" placeholder="ID" name="id">
				<button id="buttonsearchbyid" type="button" >
				<p>学生の検索</p>
				</button>
			</form>
		</div>



	<div id="add_comm" class="all" align="center">
		<h2 id="edit_title">学生の追加</h2>
		<form id="addForm" action="add" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" />
			<input id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
			<input id="addage" type="text"placeholder="年齢" name="age" class="number" />
			<input id="addscore" type="text" placeholder="成績" name="score" />
			<button id="buttonaddstudent" type="button">
			<p>添加</p>
			</button>
		</form>
	</div>

	<div id="edit_comm" class="all">
	  <h2>删除学员</h2>
	  <form id="delForm" action="deleteById" method="post" >
		<input id="delid" type="text" placeholder="要删除的id" name="id" />
		<button id="buttondelbyid" type="button">
			<p>删除</p>
			</button>
	  </form>
	  <form id="delnameForm" action="deleteByName" method="post" >
		<input id="delname" type="text" placeholder="要删除的氏名" name="name" />
		<button id="buttondelbyname" type="button">
			<p>删除</p>
			</button>
	  </form>

	  	<h2 id="edit_title">编辑学员</h2>
		<form id="editForm" action="update" method="post">
			<input id="editid" type="text" placeholder="要修改的id" name="id" placeholder="要修改的id为" />
			<button id="editstudentid" type="button">
				<p>确定</p>
				</button>
			<br> <input id="editname"type="text" placeholder="姓名" name="name" />
			<input id="editbirthday" type="text" placeholder="出生年月" name="birthday" />
			<input id="editage" type="text" placeholder="年龄" name="age" />
			<input id="editscore" type="text" placeholder="分数" name="score" />
			<button id="editstudent" type="button">
				<p>确定</p>
				</button>
		</form>
		</div>

</body>
</html>