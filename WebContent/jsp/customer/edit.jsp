﻿<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	$(function(){
		//所属行业 
		$.ajax({
			url:"${pageContext.request.contextPath }/baseDict/findBaseDict",
			type:"POST",
			dataType:"json",
			data:"dict_type_code=001",
			success:function(data){
				for(var i = 0; i < data.length;i++){
					if( "${customerView.baseDictIndustry.dict_id}"==data[i].dict_id){
						$("#cust_industry").append("<option value='"+data[i].dict_id+"' selected='selected'  >"+data[i].dict_item_name+"</option>");
					}else{
						$("#cust_industry").append("<option value='"+data[i].dict_id+"' >"+data[i].dict_item_name+"</option>");
					}
				}
			}
		});
		
		//信息来源
		$.post("${pageContext.request.contextPath }/baseDict/findBaseDict",{"dict_type_code":"002"},
				function(data){
			for(var i = 0; i < data.length;i++){
				if( "${customerView.baseDictSource.dict_id}"==data[i].dict_id){
					$("#cust_source").append("<option value='"+data[i].dict_id+"' selected='selected' >"+data[i].dict_item_name+"</option>");
				}else{
					$("#cust_source").append("<option value='"+data[i].dict_id+"'>"+data[i].dict_item_name+"</option>");
				}
			}
		},"json");
		
		//客户级别
		$.post("${pageContext.request.contextPath }/baseDict/findBaseDict",{"dict_type_code":"006"},
				function(data){
			for(var i = 0; i < data.length;i++){
				if( "${customerView.baseDictLevel.dict_id}"==data[i].dict_id){
					$("#cust_level").append("<option value='"+data[i].dict_id+"'  selected='selected' >"+data[i].dict_item_name+"</option>");
				}else{
					$("#cust_level").append("<option value='"+data[i].dict_id+"'>"+data[i].dict_item_name+"</option>");
				}
			}
		},"json");
		
		
	});

</script>



</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="${pageContext.request.contextPath }/customer/updateCustomer.action" method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="${customerView.cust_id}">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 编辑客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_name" value="${customerView.cust_name}">
								</td>
								<td>所属行业 ：</td>
								<td>
									<select name="baseDictIndustry.dict_id" class=textbox id="cust_industry" style="WIDTH: 180px">
										<option value="">---请选择---</option>
									</select>
								</td>
							</TR>							
							<TR>	
								<td>信息来源 ：</td>
								<td>
									<select name="baseDictSource.dict_id" class=textbox id="cust_source" style="WIDTH: 180px">
										<option value="">---请选择---</option>
									</select>
								</td>
								<td>客户级别：</td>
								<td>
									<select name="baseDictLevel.dict_id" class=textbox id="cust_level" style="WIDTH: 180px">
										<option value="">---请选择---</option>
									</select>							
								</td>
							</TR>
							<TR>
								<td>联系地址 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_address" value="${customerView.cust_address}">
								</td>
								<td>联系电话 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${customerView.cust_phone}">
								</td>
							</TR>
							<tr>
								<td>上传图片资源</td>
								<td >
									<font color="red">${customerView.cust_filename}</font>
									<input type="file" name="upload"   />
								</td>
							</tr>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"	border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
