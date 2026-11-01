class ProductCarousel {
    constructor(carouselType) {
        this.carouselType = carouselType;
        this.wrapper = document.querySelector(`[data-carousel-${carouselType}]`);
        this.track = document.querySelector(`[data-track-${carouselType}]`);
        this.cards = this.track.querySelectorAll(`[data-card-${carouselType}]`);
        this.prevBtn = document.querySelector(`[btn-prev-${carouselType}]`);
        this.nextBtn = document.querySelector(`[btn-next-${carouselType}]`);

        this.index = 0;
        this.updateVisibleCards();
        this.totalCards = this.cards.length;

        this.bindEvents();
        this.updatePosition();
        
        // Update on window resize
        window.addEventListener('resize', () => {
            this.updateVisibleCards();
            this.updatePosition();
        });
    }

    updateVisibleCards() {
        // Default untuk desktop: 4 card
        this.visibleCards = 4;
        
        // Untuk tablet: 2 card
        if (window.innerWidth <= 992) {
            this.visibleCards = 2;
        }
        
        // Untuk mobile: 1 card
        if (window.innerWidth <= 576) {
            this.visibleCards = 1;
        }
    }

    bindEvents() {
        this.nextBtn.addEventListener('click', () => this.next());
        this.prevBtn.addEventListener('click', () => this.prev());
    }

    next() {
        // Bisa menggeser sampai card terakhir terlihat
        if (this.index < this.totalCards - this.visibleCards) {
            this.index++;
            this.updatePosition();
        }
    }

    prev() {
        if (this.index > 0) {
            this.index--;
            this.updatePosition();
        }
    }

    updatePosition() {
        const offset = -(this.index * (100 / this.visibleCards));
        this.track.style.transform = `translateX(${offset}%)`;
        this.updateButtons();
    }

    updateButtons() {
        // Sembunyikan tombol prev jika index = 0
        if (this.index === 0) {
            this.prevBtn.classList.add('hidden');
        } else {
            this.prevBtn.classList.remove('hidden');
        }
        
        // Sembunyikan tombol next jika index sudah maksimum
        // (semua card sudah terlihat)
        if (this.index >= this.totalCards - this.visibleCards) {
            this.nextBtn.classList.add('hidden');
        } else {
            this.nextBtn.classList.remove('hidden');
        }
    }
}

// Inisialisasi kedua carousel
document.addEventListener('DOMContentLoaded', () => {
    new ProductCarousel('most-loved');
    new ProductCarousel('baked-goods');
});