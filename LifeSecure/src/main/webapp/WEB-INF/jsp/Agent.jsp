<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>LifeSecureInsurance</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
    
    <style>
    .btn-purple {
    color: #fff;
    background-color: #6f42c1;
    border-color: #643ab0;
}
.header {
  padding: 60px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 20px;
}
tr:hover{
    background-color: white;
    color :blue;
    cursor :pointer;
}
.modal-header{
       background-color: green;
      color:white;
} 



.modal-body div{float:left; width: 100%;}
.modal-body div p{float:left; width: 20%; font-weight: 600;}
.modal-body div span{float:Right; width: 50%}
</style>
<script>
    jQuery(document).ready(function($) {
    $('#example').DataTable({
        searching: false,
        responsive: true,
        "autoWidth": false,
    });
    var table = $('#example').DataTable();
    $('#example tbody').on('click', 'tr', function () {
        //console.log(table.row(this).data()0);
        $(".modal-body div span").text("");
        $(".customerid span").text(table.row(this).data()[0]);
        $(".customerfname span").text(table.row(this).data()[1]);   
        $(".customertype span").text(table.row(this).data()[2]);
        $(".customerGender span").text(table.row(this).data()[3]);
        $(".customerDob span").text(table.row(this).data()[4]);
        $(".customerEmail span").text(table.row(this).data()[5]);
        $(".contact span").text(table.row(this).data()[6]);
        $(".alternative_contact span").text(table.row(this).data()[7]);
    
        $("#myModal").modal("show");
    });
} );
</script>
</head>
<body>
<div class="header">
         <h1>Customer Details</h1>
      
 </div>
     <div class="container">
    
    <table id="example" class="display " style="width:100%">
    <thead>
        <tr>
                    <th>customer Id</th>
                    <th>customer_name</th>                    
                    <th>customer_type</th>
                    <th>customer_gender</th>
                    <th>customer_dob</th>               
                    <th > customer_email</th>  
                    <th style="display:none;">contact</th>  
                    <th style="display:none;">alternative_contact</th> 
                    
        </tr>
    </thead>
    <tbody>
       
        <c:forEach var="agent" items="${uList}">
                <tr>
                    <td ><c:out value="${agent.id}"></c:out></td>
                    <td ><c:out value="${agent.fname}  ${agent.lname}"></c:out></td>                 
                    <td ><c:out value="${agent.type}"></c:out></td>
                    <td ><c:out value="${agent.gender}"></c:out></td>
                    <td ><c:out value="${agent.dob}"></c:out></td>
                    <td ><c:out value="${agent.email}"></c:out></td>  
                    <td class="d-lg-none"><c:out value="${agent.primaryContact}"></c:out></td> 
                    <td style="display:none;"><c:out value="${agent.altanateContact}"></c:out></td>                 
                </tr>
                </c:forEach>
    </tbody>
    
</table>
   <div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
  <!-- Modal content-->
  <div class="modal-content" style= "width:130%;">
         <div class="modal-header">
          <h4 class="modal-title">Customer Details</h4>
          </div>
    <div class="modal-body" style= "width:100%">
    
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTndqKSJ-pu8liLd7K6emwZrvTstUwIzpAH0Q&usqp=CAU" alt="user image" style= "width:30%; float:right">             
           <div class="customerid" style= "width:70%"><p>customer Id: </p><span></span></div>
           <div class="customerfname" style= "width:70%"><p>customer_fname: </p><span></span></div>
           <div class="customertype" style= "width:70% "><p>customer_type: </p><span></span></div>
           <div class="customerGender" style= "width:70%"><p>customer_gender: </p><span></span></div>
           <div class="customerDob" style= "width:70%"><p>customer_dob: </p><span></span></div>
           <div class="customerEmail" style= "width:70%"><p>customer_email: </p><span></span></div>
           <div class="contact" style= "width:70%"><p>customer_AltContact: </p><span></span></div>
           <div class="alternative_contact" style= "width:70%"><p>customer_primContact: </p><span></span></div>            
          
               
    </div>  
              
              
        <div class="modal-footer">
        <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
        </div>
  </div>
   
</div>

     
           
 </div>
</div>


</body>
</html>
