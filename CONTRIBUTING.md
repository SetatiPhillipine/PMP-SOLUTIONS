# Contributing Guidelines

## Team Information

| Project | E-RANK: Digital Taxi Rank Management System |
|---------|---------------------------------------------|
| Group Name | PMP Solutions |
| Course | NPRT630 - Project |
| Institution | Sol Plaatje University |
| Year | 2026 |

---

## Team Members and Roles

| Name | Role | Primary Responsibilities |
|------|------|--------------------------|
| Oarabetse Morata | Project Lead | Overall coordination, milestone tracking, documentation completion |
| Phuti Setati | Technical Documentation Lead | GitHub management, SRS documentation, repository organisation |
| Siyabonga José Ndzobondzobo | Lead Developer & Systems Architect | Java backend, UML diagrams, code implementation |
| Kholofelo Phalakatsela | Backend Developer | Java development, queue logic, code testing |
| Louisa Mdluli | Technical Illustrator | Diagrams, research sections, document formatting |

---

## Git Workflow

### Branch Naming Convention

| Branch Type | Format | Example |
|-------------|--------|---------|
| Feature | `feature/description` | `feature/passenger-registration` |
| Bug Fix | `bugfix/description` | `bugfix/queue-position-error` |
| Documentation | `docs/description` | `docs/update-readme` |
| Testing | `test/description` | `test/unit-tests` |

### Branch Rules

1. The `main` branch is protected. No direct commits allowed.
2. All work must be done on feature branches.
3. Always pull the latest changes from `main` before creating a new branch.

### Daily Workflow

```bash
# 1. Update your local main branch
git checkout main
git pull origin main

# 2. Create a new feature branch
git checkout -b feature/your-feature-name

# 3. Make your changes and commit
git add .
git commit -m "feat: description of your changes"

# 4. Push your branch to GitHub
git push origin feature/your-feature-name

# 5. Create a Pull Request on GitHub
