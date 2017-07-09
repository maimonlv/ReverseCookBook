/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validateEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}

function validateMail(){
      var email = $("#email").val();
//  console.log("wattt");
//  $("#result").html("email is:" + email);
  if (validateEmail(email)) {
    $("#result").text(email + " is a valid Email:)");
    $("#result").css("color", "green");
  } else {
    $("#result").text(email + " is not a valid Email :(");
//    $("#result").text("please enter a good email address");
    $("#result").css("color", "red");
  }

}

function validatePassword(){
    
    
}

function validate(){
  $("#result").text("");
    validateMail();
    validatePasswords();
    return false;
}

$("#validate").bind("click", validate);