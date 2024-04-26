let h=document.querySelector("#home");
let p=document.querySelector("#profile");
let how=document.querySelector("#conduct");
h.addEventListener("mouseenter",()=>{
  h.style.background="#393939";
})
h.addEventListener("mouseleave",()=>{
  h.style.background="black";
})
p.addEventListener("mouseenter",()=>{
  p.style.background="#393939";
})
p.addEventListener("mouseleave",()=>{
  p.style.background="black";
})
how.addEventListener("mouseenter",()=>{
  how.style.background="#393939";
})
how.addEventListener("mouseleave",()=>{
  how.style.background="black";
})
let intern=document.querySelector("#intern");
let acc=document.querySelector("#acc");
let sycn=document.querySelector("#sycn");
intern.addEventListener("mouseenter",()=>{
  intern.style.background="#F8F8F8";
})
intern.addEventListener("mouseleave",()=>{
  intern.style.background="white";
})
acc.addEventListener("mouseenter",()=>{
  acc.style.background="#F8F8F8";
})
acc.addEventListener("mouseleave",()=>{
  acc.style.background="white";
})
sycn.addEventListener("mouseenter",()=>{
  sycn.style.background="#F8F8F8";
})
sycn.addEventListener("mouseleave",()=>{
  sycn.style.background="white";
})
let b1=document.querySelector(".b1");
let b2=document.querySelector(".b2");
let b3=document.querySelector(".b3");
let b4=document.querySelector(".b4");
let b5=document.querySelector(".b5");

b1.addEventListener("click",()=>{
  b1.style.background="#EADBC8";
})
b2.addEventListener("click",()=>{
  b2.style.background="#EADBC8";
})
b3.addEventListener("click",()=>{
  b3.style.background="#EADBC8";
})
b4.addEventListener("click",()=>{
  b4.style.background="#EADBC8";
})
b5.addEventListener("click",()=>{
  b5.style.background="#EADBC8";
})
b1.addEventListener("ondbclick",()=>{
  b1.style.background="white";
})

let go=document.querySelector("#go");
go.addEventListener("click",()=>{
  window.location.href="http://127.0.0.1:5500/Seniortiy/s.html";
});
