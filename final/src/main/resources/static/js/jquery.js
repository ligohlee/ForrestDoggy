$(function(){

  $('#toStayPark').mouseover(function(){
    $('#toStayPark').animate({width:'100%'},500);
  });
  $('#toStayPark').mouseleave(function(){
    $('#toStayPark').animate({width:'25%'},200);
  });

  $('#toDogVillage').mouseover(function(){
    $('#toStayPark').animate({width:'0%'},500);
    $('#toDogVillage').animate({width:'100%'},500);
  });
  $('#toDogVillage').mouseleave(function(){
    $('#toStayPark').animate({width:'25%'},200);
    $('#toDogVillage').animate({width:'25%'},200);

  });

  $('#toEatSomePlace').mouseover(function(){
    $('#toStayPark').animate({width:'0%'},500);
    $('#toDogVillage').animate({width:'0%'},500);
    $('#toEatSomePlace').animate({width:'100%'},500);
  });
  $('#toEatSomePlace').mouseleave(function(){
    $('#toStayPark').animate({width:'25%'},200);
    $('#toDogVillage').animate({width:'25%'},200);
    $('#toEatSomePlace').animate({width:'25%'},500);

  });

  $('#toDogMall').mouseover(function(){
    $('#toStayPark').animate({width:'0%'},500);
    $('#toDogVillage').animate({width:'0%'},500);
    $('#toEatSomePlace').animate({width:'0%'},500);
    $('#toDogMall').animate({width:'100%'},500);
  });
  $('#toDogMall').mouseleave(function(){
    $('#toStayPark').animate({width:'25%'},200);
    $('#toDogVillage').animate({width:'25%'},200);
    $('#toEatSomePlace').animate({width:'25%'},500);
    $('#toDogMall').animate({width:'25%'},500);

  });







});
