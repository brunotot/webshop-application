<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.brunotot.webshop.content.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">

<!-- CSS STYLING -->
<style>
.page-content {
	padding-top: 20px;
	padding-bottom: 20px;
}

.item-wrapper{
    width:60%; /* Change this depending on the resolution */
} 
    
#image {
    width:100%;
    height: 180px;
}

p {
    width: 100%; 
    text-align: center;
}

#submitBtn {
    margin-left: auto;
    margin-right: auto;
    display: block;
}

.page-wrapper {

}

.parent-vertical>.child-vertical-middle {
	padding: 9px;
}

.parent-vertical>p {
	word-break: break-all;
}

        .items {

        }
        .item-wrapper {
        	margin-left: 6px;
            display: inline-block;
            margin-top: 8px;
            margin-bottom: 8px;
            width: 220px;
            padding: 6px;
            height: 400px;
        }

        .item-content {
			border: 1px solid aqua;
			background: white;
            height: 100%;

            text-align: center;
            position: relative;
        }

        #submit {
 
        }

        #image {
            width: 100%;
        }
        
        .parent-vertical {
            display: table;
            width:100%;
        }
        .child-vertical-middle{
            display: table-cell; 
            vertical-align: middle;
        }

        .button-wrapper {
            position: absolute;
            bottom: 0;
        }
        
        @media (max-width: 768px) {
        	.item-wrapper {
        		display: initial;
        	}
        	
        	#image {
        		height: 270px;
        	}
        	
        	.item-content>div{
        		padding: 12px;
        	}
        	
        	.button-wrapper {
        		position: initial;
        	}
        }
        
        .item-wrapper-padding {
			border: 29px solid transparent;
		}
        
		@media (min-width:768px) and (max-width:992px){
			.item-wrapper-padding {
				border: 109px solid transparent;
			}
		}
		
		@media (min-width:992px) and (max-width:1200px){
			.item-wrapper-padding {
				border-left: 57px solid transparent;
				border-right: 57px solid transparent;
			}
		}

</style>
<!-- CSS STYLING -->

</head>
<body background="https://moj.tvz.hr/slika/back.png">
	<header><jsp:include page="../static/a-header.jsp"/></header>
	
	<div class="page-wrapper container">
		<div class="page-content">
			<p> TEST </p>
			<p> TEST </p>
			<p> TEST </p>
			<div class="items">
		    	<%= HtmlHelper.test("laptops") %>    
		    </div>
		</div>
	</div>
	
	<!--ref='<c:url value="/user/list" />'>Users List</a>-->
	<footer><jsp:include page="../static/footer.jsp"/></footer>
</body>
</html>