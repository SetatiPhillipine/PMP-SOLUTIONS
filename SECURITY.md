# Security Policy

## Supported Versions

| Version | Status | Support Period |
|---------|--------|----------------|
| Phase 3 (Development) | Active Development | Post May 2026 |
| Phase 4 (Production) | Planned | July 2026 |

---

## Reporting a Vulnerability

### Do Not

- Do NOT report security vulnerabilities in public GitHub issues
- Do NOT share vulnerability details in public channels (group chats, forums, social media)
- Do NOT attempt to exploit vulnerabilities on production systems

### Do This Instead

1. Report the vulnerability privately to the team contacts listed below
2. Provide clear steps to reproduce the issue
3. Include screenshots or logs if applicable
4. Allow 48 hours for an initial response
5. Work with the team to verify and resolve the issue

### Contact Information

| Role | Name | Contact |
|------|------|---------|
| Project Lead | Oarabetse Morata | 202406427@spu.ac.za |
| Lead Developer | Siyabonga Ndzobondzobo | 202441850@spu.ac.za |
| Technical Documentation Lead | Phuti Setati | 202435062@spu.ac.za |

*Emails are checked daily during project development hours.*

---

## Security Measures Implemented

### Data Encryption

| Data Type | Encryption Method | Status |
|-----------|-------------------|--------|
| Passenger ID numbers | AES-256 | Implemented |
| Passenger names | AES-256 | Implemented |
| Trip histories | AES-256 | Implemented |
| Data in transit | TLS 1.3 | Implemented |
| Data at rest | AES-256 | Implemented |

### Authentication Security

| Mechanism | Implementation | Notes |
|-----------|----------------|-------|
| Password storage | Bcrypt hashing | Salted hashes, no plain text storage |
| Taxi Owner login | Multi-factor authentication | Password + SMS verification code |
| Taxi Marshal login | PIN + Biometric | Fingerprint scan on tablet device |
| Driver login | Session tokens | Expire after 24 hours |
| Passenger login | Session tokens | Expire after 7 days |

### Database Security

| Feature | Implementation |
|---------|----------------|
| Row Level Security (RLS) | Enforced at PostgreSQL level |
| Foreign key constraints | All relationships validated |
| CHECK constraints | Roles, statuses, numeric values |
| Audit logging | All significant actions recorded |
| Failed login tracking | Brute force detection |

### API Security

| Measure | Description |
|---------|-------------|
| Input validation | All user inputs validated server-side |
| Rate limiting | 100 requests per minute per IP |
| CORS restrictions | Only allowed origins |
| JWT tokens | Stateless authentication |
| Request logging | All API calls logged |

---

## Security Architecture

### Authentication Levels by User Type

| User Type | Authentication Method | Security Level |
|-----------|----------------------|----------------|
| Taxi Owner | Password + SMS OTP | High |
| Taxi Marshal | PIN + Fingerprint | High |
| Driver | Password + Session Token | Medium |
| Passenger | Password + Session Token | Medium |

### Data Access Rules (Row Level Security)

- Users can only see their own data
- Drivers can only see their assigned trips
- Owners can only see their registered taxis
- Marshals can see queue data for their assigned rank
- Admins have full access for system management

---

## Audit and Monitoring

### What Gets Logged

| Event | Logged In |
|-------|-----------|
| Successful logins | audit_logs table |
| Failed login attempts | failed_login_attempts table |
| Trip creation | audit_logs table |
| Passenger registration | audit_logs table |
| Queue changes | audit_logs table |
| Admin actions | audit_logs table |

### Audit Log Fields

| Field | Description |
|-------|-------------|
| log_id | Unique identifier |
| user_id | User who performed action |
| action | Action type (LOGIN, TRIP_CREATED, etc.) |
| details | JSON with action-specific data |
| ip_address | Source IP address |
| device_info | Device/browser information |
| created_at | Timestamp of action |

---

## Vulnerability Response Process

Step 1: Discovery
Step 2: Private Report to Team
Step 3: Acknowledgment (within 48 hours)
Step 4: Verification by Lead Developer
Step 5: Severity Assessment
Step 6: Patch Development
Step 7: Internal Testing
Step 8: Patch Release
Step 9: Disclosure (with reporter's consent)

### Severity and Response Times

| Severity | Response Time |
|----------|---------------|
| Critical | Fix within 24 hours |
| High | Fix within 72 hours |
| Medium | Fix within 1 week |
| Low | Fix within next sprint |

---

## Security Best Practices for Contributors

### Code Guidelines

1. Never hardcode credentials
   - Use environment variables instead
   - Never commit passwords or API keys to GitHub

2. Validate all inputs
   - Check for null values
   - Validate email formats
   - Validate phone number formats
   - Check string lengths

3. Use parameterised queries
   - Never concatenate user input into SQL queries
   - Use PreparedStatement in Java
   - This prevents SQL injection attacks

4. Log security events
   - Always log authentication attempts
   - Log failed access attempts
   - Include timestamps and user identifiers

---

## Compliance and Standards

| Standard | Application |
|----------|-------------|
| POPIA (South Africa) | Passenger data protection |
| AES-256 | Encryption standard |
| Bcrypt | Password hashing |
| TLS 1.3 | Data in transit |
| WCAG 2.1 | Accessibility (contrast ratios, touch targets) |

---

## Known Limitations (Current Phase)

| Area | Limitation | Planned Resolution |
|------|------------|---------------------|
| Database hosting | Currently development-only | Production deployment in Phase 4 |
| SSL certificates | Development self-signed | Production certificates in Phase 4 |
| Rate limiting | Basic implementation | Enhanced in Phase 4 |
| Backup frequency | Manual | Automated daily backups in Phase 4 |

---

## Responsible Disclosure

The E-RANK team is committed to responsible disclosure of security vulnerabilities. Reporters who follow this policy will receive:

- Acknowledgment of receipt within 48 hours
- Credit for the discovery (unless anonymity is requested)
- Notification when the issue is resolved

---

## Security Contact Priority

For urgent security matters that cannot wait for email response, please contact multiple team members simultaneously.

---

*This policy is active as of Phase 3 and will be updated for production deployment in Phase 4.*

*Last Updated: 2026*
