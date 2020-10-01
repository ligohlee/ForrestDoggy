$(function(){

  $('#toStayPark').mouseover(function(){
    $('#toStayPark').stop().animate({width:'100%'},500);
  });
  $('#toStayPark').mouseleave(function(){
    $('#toStayPark').stop().animate({width:'25%'},200);
  });

  $('#toDogVillage').mouseover(function(){
    $('#toStayPark').stop().animate({width:'0%'},500);
    $('#toDogVillage').stop().animate({width:'100%'},500);
  });
  $('#toDogVillage').mouseleave(function(){
    $('#toStayPark').stop().animate({width:'25%'},200);
    $('#toDogVillage').stop().animate({width:'25%'},200);

  });

  $('#toEatSomePlace').mouseover(function(){
    $('#toStayPark').stop().animate({width:'0%'},500);
    $('#toDogVillage').stop().animate({width:'0%'},500);
    $('#toEatSomePlace').stop().animate({width:'100%'},500);
  });
  $('#toEatSomePlace').mouseleave(function(){
    $('#toStayPark').stop().animate({width:'25%'},200);
    $('#toDogVillage').stop().animate({width:'25%'},200);
    $('#toEatSomePlace').stop().animate({width:'25%'},500);

  });

  $('#toDogMall').mouseover(function(){
    $('#toStayPark').stop().animate({width:'0%'},500);
    $('#toDogVillage').stop().animate({width:'0%'},500);
    $('#toEatSomePlace').stop().animate({width:'0%'},500);
    $('#toDogMall').stop().animate({width:'100%'},500);
  });
  $('#toDogMall').mouseleave(function(){
    $('#toStayPark').stop().animate({width:'25%'},200);
    $('#toDogVillage').stop().animate({width:'25%'},200);
    $('#toEatSomePlace').stop().animate({width:'25%'},500);
    $('#toDogMall').stop().animate({width:'25%'},500);

  });

  $('.select').mouseover(function(){
    $('.menu').css('display','block');
  });
  $('.select').mouseleave(function(){
    $('.menu').css('display','none');
  });
  







});
