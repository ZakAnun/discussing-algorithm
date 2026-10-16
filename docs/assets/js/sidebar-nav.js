(function () {
  var STORAGE_KEY = "da-pages-sidebar-open";

  function ready(fn) {
    if (document.readyState !== "loading") {
      fn();
    } else {
      document.addEventListener("DOMContentLoaded", fn);
    }
  }

  ready(function () {
    var toggle = document.getElementById("sidebar-panel-toggle");
    var backdrop = document.getElementById("sidebar-backdrop");
    var sidebar = document.getElementById("page-sidebar");
    if (!toggle || !sidebar) {
      return;
    }

    function isOpen() {
      return document.body.classList.contains("sidebar-nav-open");
    }

    function setOpen(open) {
      document.body.classList.toggle("sidebar-nav-open", open);
      toggle.setAttribute("aria-expanded", open ? "true" : "false");
      if (backdrop) {
        backdrop.hidden = !open;
      }
      document.body.classList.toggle("sidebar-scroll-lock", open);
      try {
        localStorage.setItem(STORAGE_KEY, open ? "1" : "0");
      } catch (e) {
        /* ignore */
      }
    }

    function close() {
      setOpen(false);
    }

    toggle.addEventListener("click", function () {
      setOpen(!isOpen());
    });

    if (backdrop) {
      backdrop.addEventListener("click", close);
    }

    sidebar.querySelectorAll('a[href^="#"]').forEach(function (link) {
      link.addEventListener("click", close);
    });

    try {
      if (localStorage.getItem(STORAGE_KEY) === "1") {
        setOpen(true);
      }
    } catch (e) {
      /* ignore */
    }
  });
})();
