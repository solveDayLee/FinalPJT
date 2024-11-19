<template>
    <div class="sidebar-container">
        <div class="sidebar-inner">
            <table>
                <thead>
                    <tr>
                        <th class="main-link">
                            <a class="flex items-center gap-2">
                                <span class="icon">📑</span>전체글
                            </a>
                        </th>
                    </tr>
                    <tr class="divider"><td></td></tr>
                    <tr>
                        <th class="section-title">커뮤니티</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(category, index) in categories" :key="index">
                        <th>
                            <a class="category-link">
                                <span class="icon">{{ getCategoryIcon(index) }}</span>
                                {{ category }}
                            </a>
                        </th>
                    </tr>
                </tbody>
                <tr class="divider"><td></td></tr>
                <thead>
                    <tr>
                        <th class="section-title">에디터 게시판</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(editorCategory, index) in editorCategories" :key="index">
                        <th>
                            <a class="category-link">
                                <span class="icon">{{ getEditorIcon(index) }}</span>
                                {{ editorCategory }}
                            </a>
                        </th>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script setup>
const categories = [
    "Best 인기글(실시간)",
    "Best 인기글(명예의 전당)", 
    "수구 talk",
    "발레 talk"
]

const editorCategories = [
    "에디터 Best",
    "에디터 뉴스",
    "에디터 talk",
    "에디터 column"
]

const getCategoryIcon = (index) => {
    const icons = ['🔥', '👑', '🏊‍♂️', '💃']
    return icons[index]
}

const getEditorIcon = (index) => {
    const icons = ['⭐', '📰', '💭', '✒️']
    return icons[index]
}
</script>

<style scoped>
.sidebar-container {
    margin-left: 2rem;
    padding: 1.5rem;
    background: linear-gradient(to bottom right, #ffffff, #f8fafc);
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
    width: 250px;
    border: 1px solid #e5eef9;
}

.sidebar-inner {
    position: sticky;
    top: 2rem;
}

table {
    width: 100%;
    text-align: left;
    border-collapse: collapse;
}

.section-title {
    color: #2E64A0;
    font-size: 1.1rem;
    font-weight: 600;
    padding: 0.75rem 0;
}

.main-link {
    font-size: 1.1rem;
    font-weight: 600;
    color: #1a56db;
}

th {
    padding: 0.6rem 0;
    font-weight: normal;
    cursor: pointer;
    transition: all 0.2s ease;
}

.category-link {
    display: flex;
    align-items: center;
    gap: 0.5rem;
    color: #4b5563;
    font-size: 0.95rem;
    padding: 0.5rem;
    border-radius: 6px;
    transition: all 0.2s ease;
}

.category-link:hover {
    background-color: rgba(46, 100, 160, 0.08);
    color: #2E64A0;
    transform: translateX(4px);
}

.divider td {
    height: 1px;
    background-color: #E5EEF9;
    padding: 0;
    margin: 0.75rem 0;
}

.icon {
    font-size: 1.2rem;
    min-width: 1.5rem;
}

a {
    color: inherit;
    text-decoration: none;
    display: block;
    width: 100%;
}

@media (max-width: 768px) {
    .sidebar-container {
        margin-left: 1rem;
        margin-right: 1rem;
        width: auto;
        max-width: 250px;
    }
}

/* Dark mode support */
@media (prefers-color-scheme: dark) {
    .sidebar-container {
        background: linear-gradient(to bottom right, #1a1a1a, #262626);
        border-color: #333;
    }
    
    .section-title {
        color: #60a5fa;
    }
    
    .main-link {
        color: #60a5fa;
    }
    
    .category-link {
        color: #d1d5db;
    }
    
    .category-link:hover {
        background-color: rgba(96, 165, 250, 0.1);
        color: #60a5fa;
    }
    
    .divider td {
        background-color: #333;
    }
}
</style>