const el = document.querySelector("#module_outer");
const inner = document.querySelector("#module");

el.addEventListener("mousemove", e => {
inner.style.setProperty('--x', -e.offsetX + "px");
inner.style.setProperty('--y', -e.offsetY +"px");
});
