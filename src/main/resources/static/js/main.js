document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('quick-key-btn').addEventListener('click', async function() {
        try {
            const response = await fetch('/apii', { method: 'GET' });
            if (!response.ok) throw new Error('Failed to fetch API key');
            const data = await response.json();
            document.getElementById('new-api-key').textContent = data.apiKey;

            const modal = document.getElementById('api-key-modal');
            modal.classList.remove('hidden');
            modal.style.display = 'flex';
        } catch (error) {
            console.error('Error fetching API key:', error);
        }
    });

    document.getElementById('close-modal').addEventListener('click', function() {
        const modal = document.getElementById('api-key-modal');
        modal.classList.add('hidden');
    });

    document.querySelector('.close-modal').addEventListener('click', function() {
        const modal = document.getElementById('api-key-modal');
        modal.classList.add('hidden');
    });
});
