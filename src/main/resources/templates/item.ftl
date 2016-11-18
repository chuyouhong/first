<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="viewport" content="width=device-width">
<title>item</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<table>
  <thead>
    <tr class="trBg">
      	<th>ID</th>
		<th>姓名</th>
		<th>性别</th>
		<th>描述</th>

    </tr>
  </thead>
  <tbody>
      <#list list as cash>
		<tr>
		  	<td>${cash.id}</td>
		  	<td><#if cash.name??>${cash.name}<#else></#if></td>
		  	<td><#if cash.gender??&&cash.gender=="1">男<#elseif cash.gender??&&cash.gender=="0">女<#else></#if></td>
		  	<td><#if cash.description??>${cash.description}<#else></#if></td>
		</tr>
      </#list>
  </tbody>
</table>
</html>
