/**
 * Minimal, Smooth & Ultra-Responsive Custom Cursor
 * - Precision 1:1 tracking matching native mouse speed (zero lag/floatiness)
 * - Subtle emerald dot + smooth reactive outer ring
 * - Expands gracefully over clickable links, buttons, and cards
 * - Auto-disabled on touch/mobile devices
 */
(function() {
  // Only initialize on desktop devices with a precision pointer (mouse)
  if (typeof window === 'undefined' || !window.matchMedia('(hover: hover) and (pointer: fine)').matches) {
    return;
  }

  function initCursor() {
    // Prevent multiple initializations
    if (window.__customCursorInitialized) return;

    if (!document.body) {
      document.addEventListener('DOMContentLoaded', initCursor);
      return;
    }

    // Reuse existing DOM elements if prerendered, or create them
    let dot = document.getElementById('custom-cursor-dot');
    if (!dot) {
      dot = document.createElement('div');
      dot.id = 'custom-cursor-dot';
      dot.className = 'custom-cursor-dot';
      document.body.appendChild(dot);
    }

    let ring = document.getElementById('custom-cursor-ring');
    if (!ring) {
      ring = document.createElement('div');
      ring.id = 'custom-cursor-ring';
      ring.className = 'custom-cursor-ring';
      document.body.appendChild(ring);
    }

    // Mark as initialized
    window.__customCursorInitialized = true;

    // Enable custom cursor styles only when JS cursor is active
    document.documentElement.classList.add('has-custom-cursor');

    let mouseX = -100;
    let mouseY = -100;
    let ringX = -100;
    let ringY = -100;
    let isVisible = false;
    let isHovering = false;
    let isClicking = false;
    let isTextMode = false;
    let lastTarget = null;
    let cachedIsClickable = false;

    // Direct, instant 1:1 position update for dot (zero lag)
    window.addEventListener('pointermove', function(e) {
      mouseX = e.clientX;
      mouseY = e.clientY;

      if (!isVisible) {
        isVisible = true;
        ringX = mouseX;
        ringY = mouseY;
        dot.style.opacity = '1';
        ring.style.opacity = '1';
      }

      // 1:1 instant movement for the center precision dot
      dot.style.transform = `translate3d(${mouseX}px, ${mouseY}px, 0)`;

      // Detect hover target
      const target = e.target;
      if (!target) return;

      // Check if hovering over clickable elements
      let clickableAncestor = target.closest('a, button, [role="button"], input[type="submit"], input[type="button"], .client-marker-pin, [data-cursor-hover], select, [onclick], .clickable');
      if (!clickableAncestor) {
        let el = target;
        while (el && el !== document.body) {
          if (el.style && (el.style.cursor === 'pointer' || el.style.cursor.indexOf('pointer') !== -1)) {
            clickableAncestor = el;
            break;
          }
          try {
            if (window.getComputedStyle(el).cursor === 'pointer') {
              clickableAncestor = el;
              break;
            }
          } catch (_) {}
          el = el.parentElement;
        }
      }
      const isClickable = Boolean(clickableAncestor);

      // Check text mode: inputs, textareas, readable text elements (p, h1-h6, code, article)
      const isInput = target.tagName === 'INPUT' || target.tagName === 'TEXTAREA' || target.isContentEditable;
      const isTextContent = !isClickable && (
        isInput ||
        Boolean(target.closest('p, h1, h2, h3, h4, h5, h6, li, blockquote, pre, code, article, [data-cursor-text]'))
      );

      if (isTextContent) {
        if (!isTextMode) {
          isTextMode = true;
          dot.classList.add('cursor-hidden');
          ring.classList.add('cursor-hidden');
        }
        if (isHovering) {
          isHovering = false;
          ring.classList.remove('cursor-hover');
          dot.classList.remove('cursor-hover');
        }
        return;
      } else if (isTextMode) {
        isTextMode = false;
        dot.classList.remove('cursor-hidden');
        ring.classList.remove('cursor-hidden');
      }

      // Check if hovering over clickable elements
      let shouldHover = isClickable;
      if (!isClickable && target !== lastTarget) {
        lastTarget = target;
        try {
          const style = window.getComputedStyle(target);
          cachedIsClickable = Boolean(style && style.cursor === 'pointer');
        } catch (err) {
          cachedIsClickable = false;
        }
        shouldHover = cachedIsClickable;
      } else if (!isClickable) {
        shouldHover = cachedIsClickable;
      }

      if (shouldHover !== isHovering) {
        isHovering = shouldHover;
        if (isHovering) {
          ring.classList.add('cursor-hover');
          dot.classList.add('cursor-hover');
        } else {
          ring.classList.remove('cursor-hover');
          dot.classList.remove('cursor-hover');
        }
      }
    }, { passive: true });

    // Smooth RAF loop for the outer ring (high responsiveness ~0.38 factor: zero sluggish lag)
    function animateRing() {
      if (isVisible && !isTextMode) {
        const dx = mouseX - ringX;
        const dy = mouseY - ringY;
        ringX += dx * 0.38;
        ringY += dy * 0.38;
        ring.style.transform = `translate3d(${ringX}px, ${ringY}px, 0)`;
      }
      requestAnimationFrame(animateRing);
    }
    requestAnimationFrame(animateRing);

    // Click / MouseDown tactile feedback
    window.addEventListener('pointerdown', function() {
      isClicking = true;
      ring.classList.add('cursor-active');
      dot.classList.add('cursor-active');
    }, { passive: true });

    window.addEventListener('pointerup', function() {
      isClicking = false;
      ring.classList.remove('cursor-active');
      dot.classList.remove('cursor-active');
    }, { passive: true });

    // Hide when mouse leaves window
    document.addEventListener('mouseleave', function() {
      isVisible = false;
      dot.style.opacity = '0';
      ring.style.opacity = '0';
    });

    document.addEventListener('mouseenter', function() {
      isVisible = true;
      dot.style.opacity = '1';
      ring.style.opacity = '1';
    });
  }

  window.initCustomCursor = initCursor;

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', initCursor);
  } else {
    initCursor();
  }
})();
