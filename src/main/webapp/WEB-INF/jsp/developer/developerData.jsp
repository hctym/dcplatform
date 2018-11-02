<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

        <c:choose>
	             <c:when test="${map.list.size() > 0 }">
	               <c:forEach items="${map.list }" var="developer" varStatus="status">
			          <tr>
			            <td>${status.index+1 }</td>
			            <td>${developer.name }</td>
			            <td>${developer.account }</td>
			            <td>${developer.mobile }</td>
			            <td>${developer.email }</td>
			            <td>
				            <jsp:useBean id="dateValue" class="java.util.Date"/>
							<jsp:setProperty name="dateValue" property="time" value="${developer.ctime * 1000}"/>
							<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/>
			            </td>
			            <td class="td-status">
			               <c:if test="${developer.status == 1 }">
			                   <span class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td>
			               </c:if>
			               <c:if test="${developer.status != 1 }">
			                   <span class="layui-btn layui-btn-normal layui-btn-mini layui-btn-disabled">已禁用</span></td>
			               </c:if>
			            <td class="td-manage">
			               <c:if test="${developer.status == 0 }">
				              <a onclick="enable(${developer.id},'1')" href="javascript:;"  title="启用">
				                <i class="layui-icon">&#xe62f;</i>
				              </a>
			               </c:if>
			               <c:if test="${developer.status == 1 }">
			                  <a onclick="enable(${developer.id},'0')" href="javascript:;"  title="禁用">
				                <i class="layui-icon">&#xe601;</i>
				              </a>
			               </c:if>
			               <a title="编辑"  onclick="x_admin_show('编辑','editPage?id=${developer.id}',650,460)" href="javascript:;">
			                <i class="layui-icon">&#xe642;</i>
			              </a>
<%-- 			              <a onclick="x_admin_show('修改密码','updatePassPage?id=${developer.id}',650,460)" title="修改密码" href="javascript:;"> --%>
<!-- 			                <i class="layui-icon">&#xe631;</i> -->
<!-- 			              </a> -->
			              <a title="删除" onclick="mdel('${developer.id}')" href="javascript:;">
			                <i class="layui-icon">&#xe640;</i>
			              </a>
			            </td>
			          </tr>
		            </c:forEach>
		          </c:when>
		          <c:otherwise>
		                 <tr>
							<td colspan="8" style="text-align:center;">没有数据</td>
						</tr>
		          </c:otherwise>
	          </c:choose>